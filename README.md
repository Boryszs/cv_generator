# Cv Generator

### Technologies:
- Java 11
- Spring Boot
- Lombok
- Model Mapper
- iText

#### Simple cv generator

GET
```sh
https://generatorcv.herokuapp.com/style
```

```sh
[
  {
    "name":string 
    "url":string
  },
  {
    "name":string 
    "url":string
  },
  {
    "name":string 
    "url":string
  }
]

```

POST
```sh
https://generatorcv.herokuapp.com/cv
```

```sh
{
"name":string,
"surname":string,
"about":string,
"educations":[
	{"from":string,"to":string,"name":string,"schoolName":string},
	{"from":string,"to":string,"name":string,"schoolName":string},
],
"skills":[
	{
		name:string
	}
],
"careers":[
	{"from":string,"to":string,"company":string,"jobTitle":string,"about":string},
	{"from":string,"to":string,"company":string,"jobTitle":string,"about":string}
]
"address":string,
"telephone":string,
"email":string,
"languages":[
	{"name":string,"level":string},
	{"name":string,"level":string}
],
"interests":[
		{
		"name":string
		},
		{
		"name":string
		}	
],
"medias": [
	{
		"name":string,
		"link":string
	}
],
"courses": [
		{
		"name":string
		},
		{
		"name":string
		}
],
"colorStyle":string
}

```
