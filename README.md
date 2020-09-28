## Make Magic API
### A HarryPotter Universe Api
  
### O Projeto 
Inteiramente inteiro foi concebido na linguagem Java utilzando o Spring e outras dependências como Spring Data e o Spring Cache.     


## Build no Docker
Abra o terminal na raiz do projeto no diretório `makemagicapi` e digite o comando: `sudo docker up --build`.   

### Endpoints 
Os principais `endpoints` da Api:  

| Método  |  Endpoint  |
| ------------------- | ------------------- |
|  `GET`  |  `/api/v1/personas` |
|  `GET`  |  `/api/v1/personas{id}` |
|  `POST`  |  `/api/v1/personas` |
|  `PUT`  |  `/api/v1/personas/{id}` |
|  `DELETE`  |  `/api/v1/personas/{id}` |



### Filtros
É possível filtrar todos os personagens pelas suas respectivas casas através do `endpoint`:  
* `GET` - /api/v1/personas?house={houseId}

 
### Resumo das Tecnologias
Abaixo segue uma lista resumida de tecnologias utilizadas na concepção desse projeto: 
* Redis for Caching
* Swagger2   
* Spring Data JPA MySQL  
* Retrofit 2.3.0    
* Lombok 
