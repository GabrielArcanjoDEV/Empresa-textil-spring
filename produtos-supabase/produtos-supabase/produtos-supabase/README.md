# Produtos — API REST com Spring Boot, JPA e Supabase

Projeto baseado no roteiro de continuação prática da aula de JPA e Supabase.

## Estrutura

```text
src/main/java/br/edu/aula/produtos/
├── ProdutosApplication.java
├── entity/
│   └── Produto.java
├── repository/
│   └── ProdutoRepository.java
├── service/
│   └── ProdutoService.java
└── controller/
    └── ProdutoController.java
```

## Tecnologias

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Supabase
- Maven

## 1. Configurar o Supabase

1. Abra o projeto no Supabase.
2. Entre em **Connect** e copie os dados de conexão PostgreSQL.
3. Copie `src/main/resources/application-local.properties.example`.
4. Renomeie a cópia para `application-local.properties`.
5. Preencha `HOST`, `USUARIO` e `SENHA`.

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://HOST:5432/postgres?sslmode=require
spring.datasource.username=USUARIO
spring.datasource.password=SENHA
spring.datasource.driver-class-name=org.postgresql.Driver
```

**Atenção:** não envie `application-local.properties` para o GitHub. O arquivo já está protegido pelo `.gitignore`.

## 2. Conferir o ambiente

No terminal:

```bash
java --version
```

O roteiro utiliza Java 17.

## 3. Compilar

No Windows, com Maven instalado:

```powershell
mvn clean compile
```

## 4. Executar

```powershell
mvn spring-boot:run
```

Quando aparecer `Started ProdutosApplication`, a aplicação estará disponível em:

```text
http://localhost:8080
```

## 5. Tabela criada pelo Hibernate

Ao iniciar a aplicação pela primeira vez, o Hibernate criará ou atualizará a tabela `produtos` no PostgreSQL do Supabase.

Campos principais:

- `id`
- `nome`
- `preco`
- `quantidade_estoque`
- `ativo`

Não é necessário clicar em **New table** no Supabase para esta prática, pois o Hibernate faz a criação com base na entidade `Produto`.

## 6. Testar a API

### Cadastrar produto

No PowerShell:

```powershell
curl.exe -i -X POST "http://localhost:8080/produtos" `
  -H "Content-Type: application/json" `
  -d '{"nome":"Monitor","preco":900.00,"quantidadeEstoque":5,"ativo":true}'
```

### Listar produtos

Abra no navegador:

```text
http://localhost:8080/produtos
```

### Buscar por ID

```text
http://localhost:8080/produtos/1
```

### Atualizar produto

```powershell
curl.exe -i -X PUT "http://localhost:8080/produtos/1" `
  -H "Content-Type: application/json" `
  -d '{"nome":"Monitor atualizado","preco":950.00,"quantidadeEstoque":8,"ativo":true}'
```

### Excluir produto

```powershell
curl.exe -i -X DELETE "http://localhost:8080/produtos/1"
```

## Fluxo da aplicação

```text
JSON -> Controller -> Service -> Repository -> Hibernate -> SQL -> PostgreSQL/Supabase
```

## Se algo não funcionar

- **java não reconhecido:** confira se o JDK 17 está instalado e reabra o VS Code.
- **BUILD FAILURE:** leia o primeiro erro exibido no terminal.
- **Falha de conexão:** confira host, usuário, senha, porta 5432 e conexão com a internet.
- **404 em `/`:** use `/produtos`.
- **Porta 8080 ocupada:** pare a execução anterior com `Ctrl + C`.
- **Tabela não aparece:** atualize o Table Editor do Supabase e confira se a aplicação iniciou corretamente.
