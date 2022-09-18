const tableContent = document.querySelector('#table-content')
fetch('http://localhost:8080/filmes')
        .then(res => res.json())
        .then(data => {
            const filmes = data
            const createRow = (obj) => {
                const row = document.createElement('tr')
                const objKeys = Object.keys(obj)
                console.log(objKeys)
                objKeys.map((key) => {
                    if(key != "id"){
                        const cell = document.createElement('td')
                        const span = document.createElement('span')
                        span.setAttribute("name", key)
                        
                        span.innerHTML = key == "atores" ? obj[key].map((ator) => ator["nome"]) : obj[key] 
                        cell.appendChild(span)
                        row.appendChild(cell)
                    }
                })
                return row;
            }
            filmes.map((filme) => tableContent.appendChild(createRow(filme)))
        })
        .catch(error => console.log(error))