export async function getFeedbackAPI() {
    try {
        const response = await fetch('/api/', {
            method: 'GET',
        });
        return await response.json();
    }
    catch(error) {
        console.log('Error fetching data')
        console.log(error)
    }
    
}

export async function postFeedbackAPI(data) {
    try {
        const response = await fetch('/api/', {
            method: 'POST',
            headers: {'Content-Type': 'application/json; charset=utf-8'},
            body: JSON.stringify(data),
            redirect: 'follow',
          })
    } catch(error) {
        console.log('Error posting data')
        console.log(error)
    }
    
}