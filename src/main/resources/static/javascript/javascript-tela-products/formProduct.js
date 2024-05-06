// quando botão focar clicado, os dados serão enviados pro back
// printo um window.alert avisando que o produto foi adicionado.
// reseto o formulário
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
