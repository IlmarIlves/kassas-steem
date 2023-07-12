<script setup>
import { ref } from 'vue';
import axios from 'axios';

const ingredientsData = ref([]);

const fetchData = async (order) => {
    try {
        const response = await axios.get(`http://localhost:8080/api/ingredients/order/${order}`);
        ingredientsData.value = response.data.map(item => ({
            id: item.id,
            name: item.name,
            quantity: item.quantity
        }));
    } catch (error) {
        console.error(error);
    }
};
</script>


<template>
    <div class="home">
        <h1 class="home-title">Welcome to the ingredient list</h1>
        <p class="home-content">This is the content of the ingredient list.</p>

        <div class="input-container">
            <button @click="fetchData('desc')">Fetch Ingredients (Descending)</button>
            <button @click="fetchData('asc')">Fetch Ingredients (Ascending)</button>
        </div>

        <div>
            <ul class="ingredient-list">
                <li v-for="ingredient in ingredientsData" :key="ingredient.id">
                    <span>Name: {{ ingredient.name }}</span>
                    <span> | </span>
                    <span>Quantity: {{ ingredient.quantity }}</span>
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
  