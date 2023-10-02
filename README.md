# Standard_project_dio-Spring-boot

Neste projeto, o objetivo é demonstrar a utilização de Padrões de Projetos em Java, como Singleton, Facade e Strategy, para implementar um sistema de gerenciamento de clientes.

##🛠️ Funcionamento do Programa

O programa utiliza o banco de dados relacional h2 para fins de teste é o mysql para produção, permitindo o CRUD (inserir deletar atualizar e deletar) usuarios . O sistemas utliza a API viaCep para fazer consulta de informações de endereço a partir do cep.


## 🌐 Consumo da API ViaCep 

O projeto consome a API ViaCep para obtenção dos dados de endereço do cliente. Para isso, é utilizada a biblioteca "Retrofit", que facilita o consumo de APIs REST em Java. Os dados de endereço são obtidos a partir do CEP informado pelo usuário e são armazenados no objeto "Endereço".
