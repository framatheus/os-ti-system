# Sistema de Ordem de Serviço de TI (Java)

Este repositório contém um sistema simples de **Ordem de Serviço (OS) para TI**, desenvolvido em **Java** como parte do meu portfólio de desenvolvedor freelancer júnior em Sorocaba/SP.

A ideia é simular o dia a dia de um técnico de informática ou pequena assistência, permitindo cadastrar clientes e ordens de serviço de forma simples, via console.

---

## 🎯 Objetivos do projeto

- Praticar **Java 17** com **Maven**.
- Demonstrar **boas práticas de organização de código** (camadas: model, repository, service, view).
- Mostrar um exemplo de sistema que poderia ser usado por técnicos de TI de Sorocaba para organizar atendimentos.

O código fonte do sistema está dentro da pasta:

os-ti-system/

Funcionalidades já implementadas

Cadastro de clientes:
 - Nome
 - Telefone
 - Endereço
 - Observações
 - Listagem de clientes cadastrados

Abertura de ordens de serviço (OS):
 - Associa a OS a um cliente existente
 - Descrição do problema
 - Valor estimado
 - Status inicial: ABERTA

Listagem de ordens de serviço

Tudo feito via menu de console.


Tecnologias utilizadas
 - Java 17
 - Maven
 - Exec Maven Plugin (para rodar a aplicação pelo terminal)

src/main/java/br/com/tisystem/os
 ├─ model
 │   ├─ Cliente.java
 │   └─ OrdemServico.java
 ├─ repository
 │   ├─ ClienteRepository.java
 │   └─ OrdemServicoRepository.java
 ├─ service
 │   ├─ ClienteService.java
 │   └─ OrdemServicoService.java
 ├─ view
 │   └─ MenuView.java
 └─ App.java

model → classes de domínio (entidades)
repository → armazenamento em memória (listas)
service → regras de negócio
view → interação via console (menu)
App → ponto de entrada da aplicação

▶️ Como executar o projeto

Entre na pasta do projeto Maven:

cd os-ti-system

Compile o projeto:

mvn package

Execute a aplicação:

mvn exec:java -Dexec.mainClass="br.com.tisystem.os.App"

Use o menu no console para:
 - Cadastrar clientes
 - Listar clientes
 - Abrir OS
 - Listar OS

🚀 Próximos passos (roadmap)

Algumas melhorias planejadas:

Atualizar status da OS (ABERTA, EM_ANDAMENTO, CONCLUIDA)

Listar OS por status

Relatório simples de faturamento (somando OS concluídas)

Persistência em arquivo ou banco de dados (ex: SQLite / MySQL)

Versão futura com interface gráfica (JavaFX) ou API REST (Spring Boot)

👤 Autor

Desenvolvido por Matheus Franchin
Freelancer júnior em desenvolvimento Java – Sorocaba/SP