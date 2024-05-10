const buttonAddProduct = document.querySelector(".button-add-product");
const buttonListProduct = document.querySelector(".button-list-products");

buttonAddProduct.addEventListener("click", openFormForSaveProduct);
buttonListProduct.addEventListener("click", returnsAlistOfProducts);

// quando clicar no botão adicionar produto, fará uma requisição para uma página de form, que será um formulário para salvar um produto.

function openFormForSaveProduct() {
    const fetchPromise = fetch(
        "http://localhost:8080/formProduct"
    );

    fetchPromise
        .then((response) => {
            window.location.href = response.url;
        })
        .catch((error) => {
            console.log(`Error ${error}`);
        });
}

function returnsAlistOfProducts() {
    const fetchPromise = fetch(
        "http://localhost:8080/listOfProducts"
    );

    fetchPromise
        .then((response) => {
            window.location.href = response.url;
        }).catch((error) => {
            console.log(`Error: ${error}`);
        });

}