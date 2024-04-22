const buttonProduct = document.querySelector(".buttonProduct");

buttonProduct.addEventListener("click", telaProducts);

function telaProducts() {
    const fetchPromise = fetch(
        "http://localhost:8080/products"
    );

    fetchPromise
        .then((response) => {
            window.location.href = response.url;
        })
        .catch((error) => {
            console.log(`Bad request! ${error}`);
        });
}