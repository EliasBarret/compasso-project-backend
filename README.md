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

```
* Get - localhost:8080/city/?name=Olinda
* Get - localhost:8080/client/?name=Elias
* Get - localhost:8080/client/[id]
* Post - localhost:8080/city
* Post - localhost:8080/client
* Put - localhost:8080/client/[id]
* Delete - localhost:8080/client/[id]
```

#### Configuração BD

* Mongo DB
```
 use compasso-processamento
 bd.createCollection("compasso")
```

#### Exemplos

```
{
    "name":"Olinda",
    "state":"PE"
}
```

```
{
	"name":"Lorem Ipsum",
	"gender":"Masculino",
	"birthday":"10-12-1989",
	"age": 31,
	"city":{
			"id": "5e6260c43f7a93765c7f1d5d",
    	  	"name": "Olinda",
			"state": "PE" 
	       }
}
```

### Autor

* **Elias Barreto** - *Projeto_BackEnd_REST/API* - [@eliasbarret](https://github.com/eliasbarret)