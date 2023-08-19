<h1 align="left">Challenge-ONE-Hotel-Alura</h1>
<img src="https://github.com/Gui-Rigaud/Challenge-ONE-Hotel-Alura/assets/115510639/24982e47-d7b0-4605-8901-c4afefb62a68" />

<p>
  Este projeto trata-se de um sistema para um Hotel que inclui o cadastro das reservas e dos hóspedes. Além disso, é possível consultar a reserva e as informações do hóspede, bem como excluí-las e editá-las.
</p>

<h1 align="left">Status do Projeto</h1>
<p>
  <img src="https://img.shields.io/badge/STATUS-CONCLUÍDO-green" />
</p>

# :hammer: Funcionalidades do projeto

- `Menu Principal`: Ao executar o programa MenuPrincipal.java do pacote br.com.hotelalura.views, é possível obter acesso ao menu principal com o botão para acessar a tela de Login.
- `Autenticação de Usuário`: Ao acessa o login, será preciso informar o nome de usuário e a senha cadastradas no banco de dados previamente (SQL/Iniciando o banco de dados.sql) para acessar o sistema.
- `Menu de Usuário`: Depois de autenticar, o usuário será direcionado à tela inicial do sistema, onde poderá escolher se deseja cadastrar uma reserva ou buscar uma reserva.

<h4>Cadastro de uma reserva</h4>

- `Informar Check-in e Check-out`: Caso escolha o cadastro de reserva, será solicitado que o usuário informe qual a data de Entrada e a de Saída;
- `Valor total da reserva`: Depois de informar as datas de Entrada e Saída, o valor estará disponível automaticamente e não pode ser modificado diretamente;
- `Forma de pagamento`: Após isso, usuário precisará escolher a forma de pagamento de preferência da reserva;
- `Informações pessoais`: Na última tela para finalizar a reserva, o hóspede precisará informar seus dados pessoais (Nome, Sobrenome, Data de Nascimento, etc.) e depois irá clicar em "Salvar".
- `Janela de confirmação`: Caso tudo corra corretamente, irá ser aberta uma aba de confirmação com o número de reserva e outra com uma mensagem informando que a reserva foi bem sucedida.

<h4>Busca de reserva</h4>

- `Mecanismo de busca`: Caso escolha bucar uma reserva, deverá informar o sobrenome ou o número da reserva no campo de "Buscar" e clicar no botão;

<h4>Editar a reserva</h4>

- `Aba "Reserva"`: Caso queira editar alguma informação da sua reserva, clique duas vezes no campo e edite. Após isso, selecione o número da reserva, clique no botão "Editar" e marque a opção "Minha reserva" na janela aberta.
- `Aba "Hóspedes"`: Caso queira editar alguma informação pessoal, clique duas vezes no campo e edite. Depois, selecione o número do hóspede, clique no botão "Editar" e marque a opção "Minhas informações pessoais".

Obs: ‼️ Não edite o número da reserva nem o do hóspede. Caso faça, irá gerar um erro. ‼️

<h4>Deletar a reserva</h4>

- `Deletar`: Selecione o número da reserva e clique no botão "Deletar".

# 📁 Acesso ao projeto

Para o projeto ser executado, é preciso [baixá-lo](https://github.com/Gui-Rigaud/Challenge-ONE-Hotel-Alura/archive/refs/heads/main.zip);

# 🛠️ Abrir e rodar o projeto

Após baixar o projeto, você pode abrir com o Eclipse IDE. Para isso, na tela do Eclipse clique em:

- `File/Arquivo`
- Após isso, clique em `Import -> General -> Existing projects into workspace`;
- Por fim, selecione o arquivo extraído e importe.

Depois de realizar esse procedimento, será preciso incluir algumas bibliotecas. Para realizar isso, clique no nome do projeto importado e:

- Selecione o projeto e clique com o botão direito do mouse.
- Procure "build path";
- Depois, vá em "Include Externals JARs..." e procure a pasta "JARS" dentro deste projeto;
- Selecione todos os arquivos da pasta e depois clique em "Open";
- Por fim, clique em "Apply and Close".

Em seguida, será preciso iniciar o banco de dados na sua máquina. Para realizar isso, crie uma conexão com "localhost:3306" e execute o arquivo presente no diretório deste projeto na pasta "SQL".

Por fim, você pode abrir o projeto e realizar os seguintes passos:

- Procurar o pacote `br.com.hotelalura.views`;
- Abrir o arquivo `MenuPrincipal.java` e executá-lo.

# Autores

| [<img src="https://avatars.githubusercontent.com/Gui-Rigaud" width=115><br><sub>Guilherme Rigaud</sub>](https://github.com/Gui-Rigaud) | 
| :---: |
