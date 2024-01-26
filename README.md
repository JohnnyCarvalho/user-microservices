<h1 align="center">
    Projeto CRUD de usuário com microservices
</h1>

```javascript
@Autor Johnny Carvaho
@Date 2024
```

## Principais tecnologias utilizadas: <br/>
<p>
  <img align="center" alt="Angular" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/angularjs/angularjs-original.svg" />
  <img align="center" alt="Java" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" />
  <img align="center" alt="Spring" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" />
</p>

## Resumo do projeto

Este é um projeto para aperfeiçoamento das habilidades em Angular e Java, utilizando a arquitetura de micro serviços. Nessa aplicação irei implementar um CRUD de usuário e comunicação com um broker para envio de e-mail.
Esse projeto será executado em etapas, a começar pelo back-end e finalizando com a implementação do front-end:

## Etapas do projeto
####
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/loading.gif"> - Em andamento. <br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/ok.png"> - Concluído.

### Projeto geral
<img align="center" height="20" width="20" src="./front-end/src/assets/icons/ok.png"> - Criar story board.<br>
<img align="center" height="20" width="20" src="./front-end/src/assets/icons/ok.png"> - Criar personas e estória de usuário.<br>
<img align="center" height="20" width="20" src="./front-end/src/assets/icons/ok.png"> - Criar protótipo.<br>
<img align="center" height="20" width="20" src="./front-end/src/assets/icons/loading.gif"> - Demais assuntos que ainda não foram abordados.<br>

### Front end
<img align="center" height="20" width="20" src="./front-end/src/assets/icons/ok.png"> - Criar projeto angular.<br>
<img align="center" height="20" width="20" src="./front-end/src/assets/icons/loading.gif"> - Criar arquitetura de pastas.<br>
<img align="center" height="20" width="20" src="./front-end/src/assets/icons/loading.gif"> - Instalar e configurar as dependências do projeto.<br>
<img align="center" height="20" width="20" src="./front-end/src/assets/icons/loading.gif"> - Demais etapas ainda não definidas.<br>


## Como executar o projeto

### Front End
Para que o código funcione corretamente deve-se ser instalados as seguintes ferramentas:
- Node em <a>https://nodejs.org/en/download/</a>

Certifique-se de que o ```npm``` foi instalado junto, geralmente ele é instalado jundo com o node, para isso de o seguinte comando no terminal
````
npm --v
````
Após a instalação e configuração do Node, deve-se instalar as seguintes ferramentas através do terminal:

- Pacotes para trabalhar com node.ts 
````
npm install typescript ts-node @types/node --save-dev
````
  - Isso instala três pacotes como dependências de desenvolvimento em seu projeto: 
    - typescript: a cadeia de ferramentas do TypeScript.
    - ts-node: um pacote para executar aplicativos do TypeScript sem compilação prévia para JavaScript.
    - @types/node: as definições de tipo do TypeScript para o Node.js.
- Angular CLI 
```
npm i @angular/cli
```
- Angular Material 
```
ng add @angular/material
```

### Back End
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/ok.png"> - Criar projeto Node.ts.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/ok.png"> - Criar arquitetura de pastas.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/ok.png"> - Instalar e configurar as dependências do projeto.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/ok.png"> - Criar e configurar o index para subir o servidor.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/ok.png"> - Criar e configurar arquivo .env para armazenar as variáveis de ambiente.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/ok.png"> - Criar e configurar arquivo config para acessar as variáveis de embiente.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/ok.png"> - Criar arquivo .app e importar as dependências necessárias.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/ok.png"> - Criar rotas para acesso do front end.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/ok.png"> - Criar o controller para que as funções sejam acessadas.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/loading.gif"> - Criar função para acessar o banco de dados POST.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/loading.gif"> - Criar função para acessar o banco de dados DELETE.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/loading.gif"> - Criar função para acessar o banco de dados PUT ou PATCH.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/loading.gif"> - Criar função para acessar o banco de dados GET.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/loading.gif"> - configurar o prisma no projeto.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/loading.gif"> - Criar uma ORM com prisma e postgreSql.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/loading.gif"> - Conectar com front end.<br>
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/loading.gif"> - Testar.<br>

Para que o código funcione corretamente deve-se ser instalados as seguintes ferramentas:

- Node em <a>https://nodejs.org/en/download/</a> (caso não tenha instalado ainda)
- Express em 
````
npm install express –save
````
A última coisa a ser feita é adicionar um arquivo tsconfig.json para garantir que o TypeScript esteja configurado corretamente para o aplicativo que você irá compilar.
````
npm install @prisma/cli --save-dev
````
Como prática recomendada, aconselha-se instalar o Prisma CLI localmente em seu projeto (ao invés de uma instalação global). Isso ajuda a evitar conflitos de versão caso você tenha mais de um projeto Prisma em sua máquina.
- Docker em <a>https://docs.docker.com/desktop/install/windows-install/</a>

Após a instalação e configuração das dependências deve-se seguir os seguintes passos:

 #### Passos para subir o front end
 - Abrir o navegador 
 - Navegar em sua máquina até a pasta xampp/htdocs e colar a pasta copiada (salao).

Após isso o Angular CLI irá subir um servidor local na sua máquina, geralmente a porta de acesso é a 4200, más se está estiver em uso vai aparecer uma mansagem no terminal semelhante a essa
```javascript
Port 4200 is already in use.Would you like to use a different port? (Y/n) 
```
Nesse caso, deve-se dar enter para o servidor escolher uma porta aleatória disponível. Feito isso, quando terminar de compilar, verá que no terminal ele lhe dara a rota que o servidor
está rodando, aí é só navegar até lá e pronto, aplicação front end deve estar funcionando na rota http://localhost/<porta-selecionada>

**OBS:**
Caso ocorra algum erro de execução, verifique em **node_modules** se estão instalados todos os pacotes 
existentes em :
```javascript 
package.json
```
Caso note que falta algun, deverá instalar manualmente através do terminal usando o comando ```npm install <nome do pacote + versão do pacote>```.


 #### Passos para subir o back end
<img align="center" height="20" width="20" src="./front-end/assets/img/icons/loading.gif"> - Ainda não definido
