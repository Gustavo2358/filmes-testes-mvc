
const formEl = document.querySelector('.form')
formEl.addEventListener('submit', event => {
    event.preventDefault()
    const formData = new FormData(formEl)
    const data = Object.fromEntries(formData)
    //TODO criar campos para adicionar mais de um ator de uma vez
    const dataArray = []
    dataArray[0] = data
    console.log(JSON.stringify(dataArray))
    fetch('http://localhost:8080/atores', {
        method: 'POST',
        headers: {
            'Content-Type':'application/json',
        },
        body: JSON.stringify(dataArray)
    }).then(res => res.json())
      .then(data => console.log(data))
      .catch(error => console.log(error))

})