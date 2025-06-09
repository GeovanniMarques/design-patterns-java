# 🏡 Sistema de Pedidos para Restaurante

## 📌 Descrição
Este projeto implementa um sistema de pedidos para restaurante utilizando **Spring Boot**, **Spring Data JPA** e **Spring Events**, aplicando padrões de projeto para uma arquitetura bem estruturada.

## 🛠️ Tecnologias Utilizadas
- 🖥️ **Java 21**
- 🚀 **Spring Boot**
- 📂 **Spring Data JPA**
- 🔔 **Spring Events**
- 🗄️ **Banco de Dados H2**
- ⚙️ **Maven**

## 🎯 Padrões de Projeto Aplicados
- 🏗️ **Factory Pattern** → Para a criação de pedidos.
- 🎛️ **Singleton Pattern** → Gerenciado pelo Spring via `@Service` e `@Repository`.
- 🔔 **Observer Pattern** → Implementado com **Spring Events** para notificações de status dos pedidos.

## 🚀 Como Executar o Projeto
1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seuusuario/restaurante-app.git
   cd restaurante-app
   ```
   
2. Compile e execute o projeto via Maven:

    ```bash
    mvn spring-boot:run
    ```
3. Acesse o banco de dados H2 via navegador:

- URL: http://localhost:8080/h2-console

- Driver: org.h2.Driver

- JDBC URL: jdbc:h2:mem:restaurante_db

- Usuário: sa

- Senha: (deixe em branco)

## 🚀 Gerenciamento de Pedidos

| Método   | Endpoint                               | Descrição                      |
|----------|---------------------------------------|--------------------------------|
| **POST** | `/pedidos?prato=Pizza`               | Cria um novo pedido.           |
| **GET**  | `/pedidos`                            | Lista todos os pedidos.        |
| **GET**  | `/pedidos/{id}`                       | Busca um pedido pelo ID.       |
| **PUT**  | `/pedidos/{id}?novoStatus=Pronto`     | Atualiza o status do pedido.   |


## 📢 Exemplo de Notificação (Spring Events)
```plaintext
📢 Notificação enviada: Pedido 1 atualizado para: Pronto
```

## 🏆 Autor
Desenvolvido por **Geovanni Marques** 🚀