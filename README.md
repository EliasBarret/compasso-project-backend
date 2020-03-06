# Desafio Back-End

Construção de um modelo de aplicação REST/API que contemple um cenário de cadastro de cliente e cidade.

### Técnologias Envolvidas

* Java 8
* MongoDB
* SpringBoot
* JUnit
* Git

### Ferramentas Utilizada

* Eclipse
* Bash
* Git

### Cenário

* Cadastro cidade
* Cadastro cliente
* Consulta cidade pelo nome
* Consulta cidade pelo estado
* Consulta cliente pelo nome
* Consulta cliente pelo Id
* Remove cliente
* Altera o nome do cliente

Considerando: 
* Cidades: nome e estado
* Cliente: nome completo, sexo, data de nascimento, idade e cidade onde mora.

### EndPoints

* localhost:8080/client
* localhost:8080/city

#### Exemplos

* Post - localhost:8080/city
{
    "name":"Goiana",
    "state":"PE"
}
* Post - localhost:8080/client
{
	"name":"Lorem Ipsum",
	"gender":"Masculino",
	"birthday":"10-12-1989",
	"age": 31,
	"city":{
			"id": "5e6260c43f7a93765c7f1d5d",
    	  	"name": "Goiana",
			"state": "PE" 
	       }
}

## Autor

* **Elias Barreto** - *Projeto BackEnd REST/API* - [@eliasbarret](https://github.com/eliasbarret)