## Make Magic API
### A HarryPotter Universe Api
  
### O Projeto 
Inteiramente concebido na linguagem Java utilzando o Spring e outras dependências como Spring Data e o Spring Cache.     


## Build no Docker
Abra o terminal na raiz do projeto no diretório `makemagicapi` e digite o comando: `sudo docker up --build`.   

## Overview 

### `Persona` != `Character`
Decidi ao implementar a solução, optar por um nome de entidade diferente da recomendada pelo teste. Isso se deu ao fato de eu me familiarizar melhor com o nome **Persona** do que **Character** visto que no Java `java.lang.Character` é uma das classes Wrapper que compõem a linguagem em si. *Isso não foi um problema no geral, mas resolvi utilizar outro nome para facilitar.*           

### Casas

Como requisito principal do teste, todas as propriedades pertencentes aos personagens podem ser atualizadas com exceção de apenas o `id` da `house` que representa uma das quatro casas de *Hogwarts* listadas abaixo:     

| Casa       | Id da Casa               |
|------------|--------------------------|
| `Slytherin`  | `5a05dc8cd45bd0a11bd5e071` |
| `Gryffindor` | `5a05e2b252f721a3cf2ea33f` |
| `Hufflepuff` | `5a05dc58d45bd0a11bd5e070` |
| `Ravenclaw`  | `5a05da69d45bd0a11bd5e06f` |  

**Se você tentar atualizar a propriedade `house` de um personagem com um valor diferente receberá uma mensagem de erro.**  

### Operações do CRUD 


## Todos os Personagens  
### GET - `/api/v1/personas`
Para recuperar a lista completa de personagens utilize o endpoint `/api/v1/personas`. Se desejar filtrar os personagens pelas suas respectivas casas adicione como parâmetro a este endpoint `?house={houseId}` onde `houseId` pode ser uma das quatro casas mencionadas. Retorna `204 - No Content` se a lista estiver vazia ou o parâmetro for vazio como em `?house= `.  

## Personagem por seu `id`  
### GET - `/api/v1/personas/{id}`
Para recuperar apenas um personagem utilize o endpoint `/api/v1/personas/{id}`, onde `id` é o id respectivo do personagem. 
Retorna `404 - Not Found` se não houver um personagem com o `id` informado. 


## Criar um Personagem  
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

Retorna `400 - Bad Request` com uma mensagem pertinente se a propriedade `house` for diferente de uma das quatro opções de casas mencionadas. 

## Atualizar um Personagem  
### PUT - `/api/v1/personas/{id}`
Para atualizar o registro de um personagem específico você deve utilizar o endpoint `/api/v1/personas/{id}`, onde a propriedade `id` é o id específico do personagem ao qual deseja-se atualizar. Pode-se modificar todas propriedades que considerar necessárias porém a propriedade `house` deve ser uma das quatro opções. 

Retorna `400 - Bad Request` com uma mensagem pertinente se a propriedade `house` for diferente de uma das quatro opções de casas mencionadas.   

## Deletar um Personagem  
### DELETE - `/api/v1/personas/{id}`
Para deletar um personagem específico você deve utilizar o endpoint `/api/v1/personas/{id}`, onde a propriedade `id` é o id específico do personagem ao qual deseja-se deletar. Retorna `404 - Not Found` se não houver um personagem com o `id` informado.  

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
* `GET` - `/api/v1/personas?house={houseId}`

 
### Resumo das Tecnologias
Abaixo segue uma lista resumida de tecnologias utilizadas na concepção desse projeto: 
* Docker
* Maven 3.6.3 
* Redis for Caching
* Swagger2   
* Spring Data JPA MySQL  
* Retrofit 2.3.0    
* Lombok 
