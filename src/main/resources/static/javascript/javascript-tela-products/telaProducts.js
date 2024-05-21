const buttonAddProduct = document.querySelector(".button-add-product");
const buttonListProduct = document.querySelector(".button-list-products");
const buttonProduct = document.querySelector('.buttonProduct');
const buttonRemoveProduct = document.querySelector('.button-remove-product');

buttonAddProduct.addEventListener("click", () => {
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
});
buttonListProduct.addEventListener("click", () => {
    const fetchPromise = fetch(
        "http://localhost:8080/listOfProducts"
    );

    fetchPromise
        .then((response) => {
            window.location.href = response.url;
        }).catch((error) => {
            console.log(`Error: ${error}`);
        });
});

buttonRemoveProduct.addEventListener("click", () => {
    const fetchPromise = fetch(
        "http://localhost:8080/removeProducts"
    );

    fetchPromise
        .then((response) => {
            window.location.href = response.url;
        })
        .catch((error) => {
            console.log(`Error: ${error}`);
        });
});

// quando clicar no botão adicionar produto, fará uma requisição para uma página de form, que será um formulário para salvar um produto.

buttonProduct.addEventListener('click', () => {
    const fetchPromise = fetch(
        "http://localhost:8080/products"
    );

    fetchPromise
        .then((response) => {
            window.location.href = response.url;
        })
        .catch((error) => {
            console.log(`Error: ${error}`);
        });
});
