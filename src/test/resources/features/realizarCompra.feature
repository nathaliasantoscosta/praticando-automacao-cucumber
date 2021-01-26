#language: pt
@RealizarCompraStep

Funcionalidade: Realizar compra de um item

  Cenario: Realizar compra de um item com sucesso
    Dado que eu acessei a funcionalidade de login
    E preenchi os campos de email e senha
    E cliquei no botao de login
    Quando eu selecionar um item
    E adicionar a sacola
    E preencher os dados para entrega
    E informar os dados de pagamento
    E eu confrimar a compra
    Entao a compra sera realizada com sucesso