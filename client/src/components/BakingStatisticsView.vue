<script setup>
import { ref } from 'vue';
import axios from 'axios';

// Define a reactive variable to store the response data
const bakingData = ref();

const fetchData = async () => {
    try {
        const response = await axios.get('http://localhost:8080/api/baking-items/all');
        bakingData.value = response.data.map(item => ({
            id: item.id,
            name: item.name,
            ingredients: item.ingredients
        }));

    } catch (error) {
        console.error(error);
    }
};
fetchData();
</script>

<template>
    <div class="home">
        <h1 class="home-title">Welcome to the baking stats</h1>

        <div class="stats-container">
            <ul class="item-list">
                <li v-for="item in bakingData" :key="item.id">
                    <span>Item: {{ item.name }}</span>
                    <ul class="ingredient-list">
                        <li v-for="ingredient in item.ingredients" :key="ingredient.id">
                            <div class="ingredient-details">
                                <p>Name: {{ ingredient.name }}</p>
                                <p>Quantity: {{ ingredient.quantity }}</p>
                            </div>
                        </li>
                    </ul>
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

.stats-container {
    margin-bottom: 10px;
}

.item-list {
    list-style: none;
    padding: 0;
}

.ingredient-list {
    list-style: none;
    padding: 0;
    margin-left: 20px;
}

.ingredient-details {
    margin-bottom: 5px;
}
</style>
  