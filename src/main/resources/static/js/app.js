document.addEventListener("DOMContentLoaded", function () {

    // Máscara de CPF
    const cpf = document.getElementById("cpf");

    if (cpf) {

        cpf.addEventListener("input", function () {

            let valor = cpf.value.replace(/\D/g, "");

            valor = valor.substring(0, 11);

            if (valor.length > 9) {

                valor = valor.replace(
                    /(\d{3})(\d{3})(\d{3})(\d{0,2})/,
                    "$1.$2.$3-$4"
                );

            } else if (valor.length > 6) {

                valor = valor.replace(
                    /(\d{3})(\d{3})(\d{0,3})/,
                    "$1.$2.$3"
                );

            } else if (valor.length > 3) {

                valor = valor.replace(
                    /(\d{3})(\d{0,3})/,
                    "$1.$2"
                );
            }

            cpf.value = valor;
        });
    }

    // Máscara de telefone
    const telefone = document.getElementById("telefone");

    if (telefone) {

        telefone.addEventListener("input", function () {

            let valor = telefone.value.replace(/\D/g, "");

            valor = valor.substring(0, 11);

            if (valor.length > 10) {

                valor = valor.replace(
                    /(\d{2})(\d{5})(\d{0,4})/,
                    "($1) $2-$3"
                );

            } else if (valor.length > 6) {

                valor = valor.replace(
                    /(\d{2})(\d{4})(\d{0,4})/,
                    "($1) $2-$3"
                );

            } else if (valor.length > 2) {

                valor = valor.replace(
                    /(\d{2})(\d{0,5})/,
                    "($1) $2"
                );
            }

            telefone.value = valor;
        });
    }

    // Confirmação antes de enviar formulários
    const formularios = document.querySelectorAll("form");

    formularios.forEach(function (formulario) {

        formulario.addEventListener("submit", function (event) {

            if (!formulario.checkValidity()) {
                return;
            }

            const botao = formulario.querySelector(
                'button[type="submit"]'
            );

            if (botao) {

                botao.disabled = true;

                const textoOriginal = botao.innerText;

                botao.innerText = "Salvando...";

                setTimeout(function () {

                    if (botao.disabled) {
                        botao.disabled = false;
                        botao.innerText = textoOriginal;
                    }

                }, 5000);
            }
        });
    });

});


/**
 * Confirma exclusão de registros.
 */
function confirmarExclusao(tipo) {

    let mensagem;

    if (tipo === "paciente") {

        mensagem =
            "Tem certeza que deseja excluir este paciente?";

    } else if (tipo === "consulta") {

        mensagem =
            "Tem certeza que deseja excluir esta consulta?";

    } else {

        mensagem =
            "Tem certeza que deseja excluir este registro?";
    }

    return window.confirm(mensagem);
}