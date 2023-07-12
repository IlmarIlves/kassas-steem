<script setup>
import { ref } from 'vue';
import axios from 'axios';

// Define a reactive variable to store the response data
const bakingData = ref([]);

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
    <div class="statistics">
        <h1 class="statistics-title">Baking Statistics</h1>

        <div v-if="bakingData.length > 0">
            <div class="statistics-item" v-for="item in bakingData" :key="item.id">
                <h2>{{ item.name }}</h2>
                <ul>
                    <li v-for="ingredient in item.ingredients" :key="ingredient.id">
                        <p>{{ ingredient.name }}: {{ ingredient.quantity }}</p>
                    </li>
                </ul>
            </div>
        </div>

        <div v-else>
            <p>No baking items available.</p>
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
  