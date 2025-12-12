# PicPayBot

Projeto em Java (Spring Boot) que demonstra uma arquitetura hexagonal para automatizar o site `picpay.com` usando **Playwright** (Java) e enviar uma notificação via **RabbitMQ** quando a abertura de conta for detectada.

> Observação: este projeto é um exemplo educacional. Automatizar sites públicos pode violar termos de uso. Utilize apenas em ambiente de testes/homolog ou com autorização.

## Componentes
- Java 17
- Spring Boot 3.2.x
- Playwright (Java) - automação de browser
- RabbitMQ - mensageria para notificação
- Docker Compose (opcional) para levantar RabbitMQ

## Por que RabbitMQ?
Para este requisito (enviar uma notificação simples quando uma conta for aberta), **RabbitMQ** é a opção mais simples e direta:
- Fácil de configurar localmente (image Docker com UI).
- Padrões de troca simples para notificações ponto-a-ponto.
- Baixa latência e ótimo para mensagens de controle/integração.
O **Kafka** é mais indicado para alta taxa de eventos, event sourcing e processamento de streams em grande escala.

## Como usar

### Pré-requisitos
- JDK 17+
- Maven
- IntelliJ IDEA (ou sua IDE preferida)
- Docker (opcional, para RabbitMQ)
- Internet (Playwright baixa binários do navegador na primeira execução)

### 1) Clonar / abrir projeto
Abra o projeto no IntelliJ (File -> Open -> pasta do projeto).

### 2) Rodar RabbitMQ (opcional, via Docker)
```
docker compose up -d
```
A UI do RabbitMQ fica em http://localhost:15672 (usuário: `guest` / `guest`).

### 3) Configurar application.properties
Em `src/main/resources/application.properties` ajuste `spring.rabbitmq` caso precise.

### 4) Executar
Execute a classe `com.seuprojeto.picpaybot.PicpayBotApplication` na sua IDE.

### 5) Testar endpoint
Use curl ou Postman:
```
curl -X POST http://localhost:8080/api/test/abrir-conta \
 -H "Content-Type: application/json" \
 -d '{"cpf":"11122233344","nomeCompleto":"Fulano Silva","email":"fulano@example.com","celular":"11999990000","dataNascimento":"1990-01-01"}'
```

### 6) Observações Playwright
Na primeira execução o Playwright Java pode baixar navegadores. Se preferir, instale via Node (`npx playwright install`) ou permita o download automático.

### Estrutura do projeto
Pasta `src/main/java/com/seuprojeto/picpaybot` com domínio, adapters, aplicação e controller.

## Docker Compose (RabbitMQ)
Arquivo `docker-compose.yml` incluído para facilitar.

## Licença
MIT — usar por sua conta e risco. Não utilize em produção sem as devidas permissões.
