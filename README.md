<p align="center">
  <img src="https://raw.githubusercontent.com/abdoulrl2028-cloud-Dev/abdoulrl2028-cloud-Dev/main/assets/projects/extrato.jpg" alt="Extrato bancário em Kotlin" width="100%">
</p>

# extrato-bancario-kotlin

Projeto exemplo com um app Android (Kotlin/Room/Retrofit) e um servidor Spring Boot mínimo.

Estrutura:

- `app/` - módulo Android com código fonte, Room e Retrofit.
- `server/` - API Spring Boot que expõe `/transactions` com dados mock.

Como usar:

1. Executar servidor (Java 17 + Maven):

```bash
cd server
mvn spring-boot:run
```

2. Rodar o app Android no emulador (use `10.0.2.2:8080` como `BASE_URL` no `ApiModule`).

Notas:
- Código é intencionalmente simples e educacional.
- Ajuste dependências/versões no `app/build.gradle` conforme sua setup.

Licença: MIT (arquivo `LICENSE`)
