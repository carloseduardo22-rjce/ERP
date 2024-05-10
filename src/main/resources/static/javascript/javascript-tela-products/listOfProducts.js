const buttonProduct = document.querySelector('.buttonProduct');
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