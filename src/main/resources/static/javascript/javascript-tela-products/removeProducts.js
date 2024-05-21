// colocar um ouvidor de evento no botão de remover item
// quando for clicado ele irá pegar o ID daquele item atual
// e fazer um requisição do tipo DELETE para o banco para excluir aquele item
document.querySelectorAll('.button-remove-product').forEach(button => {
    button.addEventListener('click', (e) => {
        const cod_product = e.target.getAttribute('data-cod_product');
        if (cod_product) {
            fetch(`http://localhost:8080/Products/${cod_product}`, {
                method: 'DELETE',
            })
                .then((response) => {
                    if (response.ok) {
                        alert('Product removed successfully!');
                        window.location.reload();
                    } else {
                        alert('Failed to remove product.');
                    }
                })
                .catch((error) => {
                    alert(`Error removing product: ${error}`);
                });
        }
    });
});
