## Make Magic API
### A HarryPotter Universe Api
  
### O Projeto 
Inteiramente concebido na linguagem Java utilzando o Spring e outras dependências como Spring Data e o Spring Cache.     


## Build no Docker
Abra o terminal na raiz do projeto no diretório `makemagicapi` e digite o comando: `sudo docker up --build`.   

### Operações 

## Create
### POST - `/api/v1/personas`
Para inserir um novo registro você deve utilizar o endpoint `/api/v1/personas`. É necessário passar no body da requisição os seguintes dados excluindo-se a propriedade id: 

```json
      {
        "name": "Harry Potter",
        "role": "student",
        "school": "Hogwarts School of Witchcraft and Wizardry",
        "house": "5a05dc8cd45bd0a11bd5e071",
        "patronus": "stag"
      }	
```

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
