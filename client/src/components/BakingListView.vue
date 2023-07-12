<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

// Define a reactive variable to store the response data
const bakingData = ref([]);
const bakingItemName = ref('');
const ingredients = ref([
    { name: '', quantity: '' },
    { name: '', quantity: '' },
    { name: '', quantity: '' }
]);


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

const addIngredient = () => {
    ingredients.value.push({ name: '', quantity: '' });
};

const removeIngredient = (index) => {
    ingredients.value.splice(index, 1);
};

const postData = async () => {
    // Validate ingredient quantities
    const areQuantitiesValid = ingredients.value.every(ingredient => ingredient.quantity >= 0);

    if (areQuantitiesValid) {
        if (ingredients.value.length >= 3) {
            const data = {
                name: bakingItemName.value,
                ingredients: ingredients.value
            };

            axios
                .post('http://localhost:8080/api/baking-items/add', data)
                .then(response => {
                    console.log(response.data);
                })
                .catch(error => {
                    console.error(error);
                });
        } else {
            console.log('Please provide exactly three ingredients.');
        }
    } else {
        console.log('Quantity must be a positive number for all ingredients.');
    }
};

// wait for DOMContentLoaded event
onMounted(() => {
    document.getElementById('postButton').addEventListener('click', postData);
});
</script>



<template>
    <div class="home">
        <h1 class="home-title">Welcome to the baking list</h1>
        <p class="home-content">This is the content of the baking list.</p>

        <div class="input-container">
            <input type="text" v-model="bakingItemName" />
        </div>
        <div class="ingredient-section">
            <h2>Ingredients</h2>
            <div v-for="(ingredient, index) in ingredients" :key="index" class="ingredient-item">
                <input type="text" v-model="ingredient.name" :placeholder="`Ingredient ${index + 1} Name`" />
                <input type="number" v-model="ingredient.quantity" :placeholder="`Ingredient ${index + 1} Quantity`"
                    min="0" />

                <button @click="removeIngredient(index)">Remove</button>
            </div>
            <button @click="addIngredient">Add Ingredient</button>
        </div>
        <button id="postButton">Post Data</button>

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
  