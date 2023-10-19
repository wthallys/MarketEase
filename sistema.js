const productPriceInput = document.getElementById("productPrice");
const quantityInput = document.getElementById("quantity");
const totalAmountInput = document.getElementById("totalAmount");
const generateReportButton = document.getElementById("generateReport");

productPriceInput.addEventListener("input", updateTotalAmount);
quantityInput.addEventListener("input", updateTotalAmount);

function updateTotalAmount() {
    const price = parseFloat(productPriceInput.value) || 0;
    const quantity = parseInt(quantityInput.value) || 0;
    const totalAmount = price * quantity;
    totalAmountInput.value = totalAmount.toFixed(2);
}

generateReportButton.addEventListener("click", () => {
  
    alert("Pagamento realizado com sucesso!");
});