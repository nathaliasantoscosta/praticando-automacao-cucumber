#language: pt
@RemoverItemSacolaStep

Funcionalidade: Remover item da sacola

  Cenario: Remover item da sacola com sucesso
    Dado que acessei a funcionalidade de login
    E preenchi com dados validos os campos de email e senha
    E cliquei no botao de sign in
    Quando eu selecionar um item no ecommerce
    E eu adicionar a sacola
    E clicar no botao de remover
    Entao o item sera removido com sucesso