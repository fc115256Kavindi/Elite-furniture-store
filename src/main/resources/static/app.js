const API_BASE = "http://localhost:8080/api";

const productGrid = document.getElementById("productGrid");
const cartItems = document.getElementById("cartItems");
const cartTotal = document.getElementById("cartTotal");
const cartCount = document.getElementById("cartCount");
const menuBtn = document.getElementById("menuBtn");
const navLinks = document.getElementById("navLinks");

const contactForm = document.getElementById("contactForm");
const customOrderForm = document.getElementById("customOrderForm");
const appointmentForm = document.getElementById("appointmentForm");
const newsletterForm = document.getElementById("newsletterForm");

let productsCache = [];
let cart = JSON.parse(localStorage.getItem("elite_cart")) || [];

if (menuBtn) {
  menuBtn.addEventListener("click", () => {
    navLinks.classList.toggle("show");
  });
}

document.querySelectorAll(".nav-links a").forEach(link => {
  link.addEventListener("click", () => {
    navLinks.classList.remove("show");
  });
});

async function loadProducts() {
  try {
    const response = await fetch(`${API_BASE}/products`);
    const products = await response.json();

    if (!response.ok) {
      throw new Error("Failed to fetch products");
    }

    productsCache = Array.isArray(products) ? products : [];

    if (productsCache.length === 0) {
      productGrid.innerHTML = `<p class="placeholder-text">No products found.</p>`;
      return;
    }

    productGrid.innerHTML = "";

    productsCache.forEach(product => {
      const imageUrl =
        product.imageUrl && product.imageUrl.trim() !== ""
          ? product.imageUrl
          : "images/default-product.jpg";

      const categoryName = product.category ? product.category.name : "Furniture";

      const card = document.createElement("div");
      card.className = "product-card";

      card.innerHTML = `
        <div class="product-image" style="background-image: url('${imageUrl}')"></div>
        <div class="product-content">
          <div class="product-category">${categoryName}</div>
          <h3>${product.name || ""}</h3>
          <p>${product.description || ""}</p>
          <div class="product-price">LKR ${Number(product.price || 0).toFixed(2)}</div>
          <div class="product-actions">
            <button class="add-cart-btn" onclick="addToCart(${product.id})">Add to Cart</button>
          </div>
        </div>
      `;

      productGrid.appendChild(card);
    });
  } catch (error) {
    console.error("Error loading products:", error);
    productGrid.innerHTML = `<p class="placeholder-text">Failed to load products.</p>`;
  }
}

function addToCart(productId) {
  const product = productsCache.find(item => item.id === productId);
  if (!product) return;

  const existing = cart.find(item => item.id === productId);

  if (existing) {
    existing.quantity += 1;
  } else {
    cart.push({
      id: product.id,
      name: product.name,
      price: Number(product.price || 0),
      imageUrl: product.imageUrl,
      quantity: 1
    });
  }

  saveCart();
  renderCart();
}

function removeFromCart(productId) {
  cart = cart.filter(item => item.id !== productId);
  saveCart();
  renderCart();
}

function clearCart() {
  cart = [];
  saveCart();
  renderCart();
}

function saveCart() {
  localStorage.setItem("elite_cart", JSON.stringify(cart));
}

function renderCart() {
  if (!cartItems) return;

  if (cart.length === 0) {
    cartItems.innerHTML = `<p class="placeholder-text">Your cart is empty.</p>`;
    cartTotal.textContent = "0.00";
    cartCount.textContent = "0";
    return;
  }

  cartItems.innerHTML = cart.map(item => `
    <div class="cart-item">
      <div class="cart-item-info">
        <h4>${item.name}</h4>
        <p>Price: LKR ${item.price.toFixed(2)}</p>
        <p>Quantity: ${item.quantity}</p>
        <p>Subtotal: LKR ${(item.price * item.quantity).toFixed(2)}</p>
      </div>
      <div>
        <button class="remove-btn" onclick="removeFromCart(${item.id})">Remove</button>
      </div>
    </div>
  `).join("");

  const total = cart.reduce((sum, item) => sum + item.price * item.quantity, 0);
  const count = cart.reduce((sum, item) => sum + item.quantity, 0);

  cartTotal.textContent = total.toFixed(2);
  cartCount.textContent = count;
}

function scrollToCart() {
  const cartSection = document.getElementById("cart");
  if (cartSection) {
    cartSection.scrollIntoView({ behavior: "smooth" });
  }
}

if (contactForm) {
  contactForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const data = {
      name: document.getElementById("contactName").value.trim(),
      email: document.getElementById("contactEmail").value.trim(),
      subject: document.getElementById("contactSubject").value.trim(),
      message: document.getElementById("contactMessage").value.trim()
    };

    try {
      const response = await fetch(`${API_BASE}/contact-messages`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
      });

      if (response.ok) {
        alert("Contact message sent successfully.");
        contactForm.reset();
      } else {
        alert("Failed to send contact message.");
      }
    } catch (error) {
      console.error(error);
      alert("Error sending contact message.");
    }
  });
}

if (customOrderForm) {
  customOrderForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const data = {
      customerName: document.getElementById("coName").value.trim(),
      email: document.getElementById("coEmail").value.trim(),
      phone: document.getElementById("coPhone").value.trim(),
      furnitureType: document.getElementById("coFurnitureType").value.trim(),
      preferredMaterial: document.getElementById("coMaterial").value.trim(),
      preferredColor: document.getElementById("coColor").value.trim(),
      dimensions: document.getElementById("coDimensions").value.trim(),
      estimatedBudget: parseFloat(document.getElementById("coBudget").value),
      designDetails: document.getElementById("coDetails").value.trim()
    };

    try {
      const response = await fetch(`${API_BASE}/custom-orders`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
      });

      if (response.ok) {
        alert("Custom order submitted successfully.");
        customOrderForm.reset();
      } else {
        alert("Failed to submit custom order.");
      }
    } catch (error) {
      console.error(error);
      alert("Error submitting custom order.");
    }
  });
}

if (appointmentForm) {
  appointmentForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const data = {
      customerName: document.getElementById("apName").value.trim(),
      email: document.getElementById("apEmail").value.trim(),
      phone: document.getElementById("apPhone").value.trim(),
      appointmentDate: document.getElementById("apDate").value,
      appointmentTime: document.getElementById("apTime").value,
      purpose: document.getElementById("apPurpose").value.trim(),
      note: document.getElementById("apNote").value.trim()
    };

    try {
      const response = await fetch(`${API_BASE}/appointments`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
      });

      if (response.ok) {
        alert("Appointment booked successfully.");
        appointmentForm.reset();
      } else {
        alert("Failed to book appointment.");
      }
    } catch (error) {
      console.error(error);
      alert("Error booking appointment.");
    }
  });
}

if (newsletterForm) {
  newsletterForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const data = {
      email: document.getElementById("newsletterEmail").value.trim()
    };

    try {
      const response = await fetch(`${API_BASE}/newsletter`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
      });

      if (response.ok) {
        alert("Subscribed successfully.");
        newsletterForm.reset();
      } else {
        alert("Failed to subscribe.");
      }
    } catch (error) {
      console.error(error);
      alert("Error subscribing.");
    }
  });
}

renderCart();
loadProducts();

window.addToCart = addToCart;
window.removeFromCart = removeFromCart;
window.clearCart = clearCart;
window.scrollToCart = scrollToCart;
window.loadProducts = loadProducts;