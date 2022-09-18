const formEl = document.querySelector('.form')

const atoresDiv = document.querySelector('.atores')

const addButton = document.getElementById("add")
addButton.addEventListener('click', () =>{
    fetch('http://localhost:8080/atores')
        .then(res => res.json())
        .then(data => {
            //quantida de atores
            const atoresSize = Object.keys(data).length
            //quantidade de selects
            const selects = document.querySelectorAll('select')
            const selectSize = selects.length
            if(selectSize < atoresSize){
                let atores = data
                const select = document.createElement('select')
                atoresDiv.appendChild(select)
                atores.map(ator => {
                    const option = document.createElement('option')
                    option.value = `${ator.id}`
                    option.text = `${ator.nome}`
                    select.appendChild(option)
                })
            }
        })
        .catch(error => console.log(error))
})
   

formEl.addEventListener('submit', event => {
    event.preventDefault()
    const formData = new FormData(formEl)
    const data = Object.fromEntries(formData)
    
    
    const atores = Array.from(document.querySelectorAll('select'))
                    .map(ator => parseInt(ator.value))

    data.atores_id = atores
    
    fetch('http://localhost:8080/filmes', {
        method: 'POST',
        headers: {
            'Content-Type':'application/json',
        },
        body: JSON.stringify(data)
    }).then(res => res.json())
      .then(data => console.log(data))
      .catch(error => console.log(error))

})
