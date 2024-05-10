const form = document.querySelector('.content form');
form.addEventListener('submit', async (e) => {
    e.preventDefault();
    const formData = new FormData(form);
    try {
        const response = fetch('http://localhost:8080/Products/NewProduct', {
            method: 'post',
            body: formData
        })
        form.reset();
        if ((await response).ok) {
            window.alert('Product added sucessfuly!');
        }
    } catch (error) {
        window.alert(`Error: ${error}`);
    }

});

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