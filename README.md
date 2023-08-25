# Projeto Histologia Website
Aplicação que permite a visualização de diversas lâminas histológicas, com intuíto de auxiliar os estudos sobre esse assunto. O projeto utiliza o padrão de arquitetura de software MVC, podendo ser facilmente migrado para outro padrão de arquitetura, se necessário.

# Tecnologias Utilizadas
- Java version 17.0.7 Oracle
- PostgreSQL 15.3 
  
# Dependências Utilizadas
- Spring Web
- Spring DevTools
- Spring Data JPA
- PostgreSQL Driver
- Thymeleaf
- Lombok
- Flyway
- H2 Database Engine


# Funcionalidade Visualização Lâmina
Esta é a página a qual poderemos interagir com uma determinada lâmina. Poderemos ler sua descrição, efetuar ampliação de qualquer área da lâmina e ser direcionado para uma área pré-determinada na lâmina por meio de ligações de referência no texto da lâmina, podendo assim saber a qual parte da lâmina o texto se refere.

## Estrutura da funcionalidade Visualização Lâmina
Esta funcionalidade, seguindo a estrutura do padrão MVC, sendo eles:
### Model e Controller
```bash
.
├── main
│   ├── java
│   │   └── local
│   │       └── histologia
│   │           ├── controllers
│   │           ├── entities
│   │           ├── records
│   │           ├── repositories
│   │           ├── services
│   │           └── HistologiaApplication.java
│   └── resources
└── test
```
### Model
#### Entities
**Lamina.java** - representando a tabela do banco de dados com seus atributos
#### Repositories
**LaminaRepository.java** - faz a comunicação com o banco de dados fornecendo persistência
#### Services
**LaminaService.java** - intermediário entre de comunicação com Repository e armazena a lógica e regras de negócio

### Controller
#### Controllers
**LaminaController.java** - receptora das requisições da camada **View** encaminhando estas para a camada **Model** e retornando desta sua resposta e devolvendo à camada requisitante, no caso, a camada **View** 

### Outras ferramentas usadas
#### Records
**LaminaRecord.java** - usada para encapsular e impedir exposição de todos os dados da entity

### View
```bash
.
├── main
│   ├── java
│   └── resources
│       ├── static
│       │   ├── Assets
│       │   │   ├── Annotations
│       │   │   │   └── Narratives
│       │   │   │       └── respiratorio
│       │   │   │           ├── L01TraqueiaEEpiglote-annotations.xml
│       │   │   │           ├── L03TraqueiaEEpiglote-annotations.xml
│       │   │   │           ├── LR02TraqueiaEEpigloteDeCao-annotations.xml
│       │   │   │           └── LR05Pulmao-annotations.xml
│       │   │   └── Skins
│       │   ├── css
│       │   │   └── visualizando
│       │   │       ├── article.css
│       │   │       ├── geral.css
│       │   │       └── header.css
│       │   ├── Images
│       │   │   └── respiratorio
│       │   │       └── LR05Pulmao.pff
│       │   └── ZoomifyImageViewerEnterprise-min.js
│       └── templates
│           ├── Assets
│           │   └── Narratives
│           │       └── respiratorio
│           │           ├── L01TraqueiaEEpiglote.htm
│           │           ├── L03TraqueiaEEpiglote.htm
│           │           ├── LR02TraqueiaEEpigloteDeCao.htm
│           │           ├── LR05Pulmao.htm
│           │           └── respiratorio.html
│           ├── fragments
│           │   └── visualizando
│           │       ├── article.html
│           │       └── header.html
│           └── visualizando
│               └── lamina.html
└── test
```
Para renderização da camada **View** necessitamos de diversos arquivos, cada um com sua própria funcionalidade, que ao serem unidos, compõem a página de visualização. Seguindo uma explicação top-down:

- **arquivo ZoomifyImageViewerEnterprise-min.js** - arquivo em .js para executar todas as funcionalidades sobre a lâmina, tais como ampliação, ancoragem, *layout*, *highlight*, entre muitas outras
- **arquivos .css** - em *static/css* encontramos os arquivos .css de cada funcionalidade
- **diretório Skins** - em *static/Assets/Skins* encontra-se configurações para a barra de ferramentas de ampliação da lâmina
- **lamina.html** - página principal que recebe todos os dados e funcionalidades necessários para a renderização final ao usuário. Composta por:
  - **header.html** - menu de ferramentas da página
  - **article.html** - corpo da página, recebendo a imagem da lâmina, o texto e o arquivo para efetuar ampliação
    - **texto da lâmina** - em *templates/Assets/Narratives/\<nome_do_sistema>* encontra-se diversos diretórios separados por sistemas, e dentro de cada diretório de sistema, há o textos descritivos das lâminas do sistema em formato .htm
    - **ampliação** - em *static/Assets/Annotations/Narratives/\<nome_do_sistema>* - semelhante ao *texto da lâmina*, entretanto, armazena os arquivos .xml para efetuar as ampliações na lâmina ao clicar em determinado texto
    - **lâminas** - em *static/Images/\<nome_do_sistema>* - encontra-se os arquivos .pff para visualização das lâminas 

### Outras ferramentas usadas
- **application.properties** - configurações diversas sobre a aplicação
- **banner.txt** - simplesmente texto decorativo ao iniciar springboot
- **data.sql** - arquivo para executar aplicação usando a dependência H2 Database