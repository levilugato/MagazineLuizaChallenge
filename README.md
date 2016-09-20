# MagazineLuizaChallenge

'---------- Softwares Requeridos Instalados ----------'

- JDK version >= 1.8

- Maven

- Node/NPM

- Bower

- PostgreeSQL

- Apache TomCat8

- Obs: Caso for importar projeto em Alguma IDE, utilizar Spring Tool Suite (https://spring.io/tools).

'---------- Instalando dependencias projeto Web----------'

Instalar o (https://nodejs.org/en/)[NodeJS]

Instalar Bower e o gulp como dependências globais  
- `npm install -g bower gulp`

Dentro da raiz do projeto (MagazineLuizaChallengeWeb) executar para instalar as dependências de front  
- `npm install`

Obs. Caso o comando acima não instale os plugins do bower, dentro da raiz do projeto (MagazineLuizaChallengeWeb) é necessário executar  
- `bower install`

'---------- Configuração de propriedades de Acesso ao Banco de Dados e Log----------'

- Para alterar propriedades de acesso ao banco de dados :
  Arquivo: application.properties, localizado em MagazineLuizaChallengeAPI\src\main\resources
  Propriedades: - spring.datasource.url
                - spring.datasource.username
                - spring.datasource.password
                - spring.jpa.hibernate.ddl-auto

- Para Alterar Propriedades de configuração de Log
  Arquivo: application.properties, localizado em MagazineLuizaChallengeAPI\src\main\resources
  Propriedades: - logging.level.org.springframework.web
			          - logging.level.br.com.magazineluizachallenge.api
                - logging.level.org.hibernate
                - logging.file


'---------- Instalando dependencias Api rest java ----------''

- Dentro da Raiz do projeto (MagazineLuizaChallengeAPI) mvn clean install
- Artefato do projeto (demo.war) para deploy no servidor dentro da pasta MagazineLuizaChallengeAPI/target

'---------- Deploy App Web ----------'
- Através do terminal do Node.js vá até a raiz do projeto (MagazineLuizaChallengeWeb) e execute:
  - grunt server

'---------- Deploy da Api rest java ---------'

- Deploy via Spring Tool Suite :
    - Dowload do Spring Tool Suite (https://spring.io/tools).
    - File - Import - maven - Existing Maven Projects 
    - Após a importação do projeto, abriar a classe MagazineLuizaChallengeApiApplication localizada no pacote br.com.magazineluizachallenge, clicar com o botão direito do mouse e na opção Run As, selecionar Spring Boot App.

    - Obs: Caso seja essa a opção escolhida para realizar o deploy da aplicação é importante lembrar que a url de acesso aos métodos da classe TwitterAPI será: localhost:8080/api/twitter. É importante verificar o valor da variável API_CONTEXT do arquivo config.js, localizado em : MagazineLuizaChallengeWeb\app\scripts\config.
 
- Deploy Apache TomCat Externo
  - Cópie o artefato demo.war localizado em  MagazineLuizaChallengeAPI/target.
  - Adicione o artefato demo.war na pasta webapps do servidor.
  - Startar servidor em /bin (startup).  

  - Obs: Caso seja essa a opção escolhida para realizar o deploy da aplicação é importante lembrar que a url de acesso aos métodos da classe TwitterAPI será: localhost:8080/demo/api/twitter. É importante verificar o valor da variável API_CONTEXT do arquivo config.js, localizado em : MagazineLuizaChallengeWeb\app\scripts\config.