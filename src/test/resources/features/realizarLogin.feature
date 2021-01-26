#language: pt
@RealizarLoginStep

Funcionalidade: Realizarlogin
  Como um usuario
  Eu quero realizar o login no ecommerce
  Para que eu possa realizar compras

  Cenario: Realizar login com sucesso
    Dado que eu acessei a funcionalidade login
    Quando eu preencher o campo de email
    E preencher o campo de senha
    E clicar no botao de login
    Entao realizarei o login com sucesso