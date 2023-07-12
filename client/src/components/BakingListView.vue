<script setup>
import { ref } from 'vue';
import axios from 'axios';

// Define a reactive variable to store the response data
const bakingData = ref();
const bakingItemName = ref('');

const fetchData = async () => {
    try {
        const response = await axios.get('http://localhost:8080/api/baking-items/all');
        bakingData.value = response.data.map(item => ({
            id: item.id,
            name: item.name,
        }));
    } catch (error) {
        console.error(error);
    }
};
fetchData();

const postData = async (name, ingredient, quantity) => {
    const formData = new URLSearchParams();
    formData.append('name', name,);
    formData.append('ingredient', ingredient);
    formData.append('quantity', quantity);

    axios
        .post('http://localhost:8080/api/baking-items/add', formData)
        .then(response => {
            console.log(response.data);
        })
        .catch(error => {
            console.error(error);
        });
}

// wait for html to load
document.addEventListener('DOMContentLoaded', function () {

    document.getElementById('postButton').addEventListener('click', () => postData(bakingItemName.value, 'do', 69));


});

</script>


<template>
    <div class="home">
        <h1 class="home-title">Welcome to the baking list</h1>
        <p class="home-content">This is the content of the baking list.</p>

        <div class="input-container">
            <input type="text" v-model="bakingItemName" />
            <button id="postButton">Post Data</button>
        </div>

        <div>
            <ul class="baking-list">
                <li v-for="item in bakingData" :key="item.id">
                    <router-link :to="`/details/${item.id}`">{{ item.name }}</router-link>
                </li>
            </ul>
        </div>
    </div>
</template>
  
<style>
.home {
    margin: 20px;
}

.home-title {
    font-size: 24px;
    font-weight: bold;
}

.home-content {
    margin-bottom: 10px;
}

.input-container {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    margin-bottom: 10px;
}

.baking-list {
    list-style: none;
    padding: 0;
}

.baking-list li {
    margin-bottom: 5px;
}
</style>
  