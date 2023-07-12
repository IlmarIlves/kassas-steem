<script setup>
import { ref } from 'vue';
import axios from 'axios';

// Define a reactive variable to store the response data

const url = window.location.href;
const lastParam = url.split("/").slice(-1)[0];

// Define a reactive variable to store the response data
const bakingData = ref([]);

const fetchData = async () => {
    try {
        const response = await axios.get(`http://localhost:8080/api/baking-items/${lastParam}`);
        bakingData.value = {
            id: response.data.id,
            name: response.data.name,
            ingredients: response.data.ingredients
        };

    } catch (error) {
        console.error(error);
    }
};
fetchData();

</script>

<template>
    <div class="home">
        <h1 class="home-title">Welcome to the baking details</h1>
        <p class="home-content">This is the content of the baking details.</p>

        <div class="details-container">
            <span>Name: {{ bakingData.name }}</span>
            <ul class="ingredient-list">
                <li v-for="ingredient in bakingData.ingredients" :key="ingredient.id">
                    <div class="ingredient-details">
                        <p>Ingredient name: {{ ingredient.name }}</p>
                        <p>Quantity: {{ ingredient.quantity }}</p>
                    </div>
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

.details-container {
    margin-bottom: 10px;
}

.ingredient-list {
    list-style: none;
    padding: 0;
}

.ingredient-details {
    margin-bottom: 5px;
}
</style>
  