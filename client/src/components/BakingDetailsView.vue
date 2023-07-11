<script setup>
import { ref } from 'vue';
import axios from 'axios';

// Define a reactive variable to store the response data

const url = window.location.href;
const lastParam = url.split("/").slice(-1)[0];

// Define a reactive variable to store the response data
const bakingData = ref();

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

        <!-- TODO: fix errors & warnings here -->
        <div>
            <span>Name: {{ bakingData.name }}</span>
            <ul>

                <li v-for="ingredient in bakingData.ingredients" :key="ingredient.id">
                    <div>
                        <p>Ingredient name: {{ ingredient.name }}</p>
                        <p> Quantity: {{ ingredient.quantity }}</p>
                    </div>
                </li>
            </ul>

        </div>
    </div>
</template>
  

  
<style scoped>
.home {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
}

.home-title {
    font-size: 2.5rem;
    color: #333;
    margin-bottom: 1rem;
}

.home-content {
    font-size: 1.2rem;
    color: #666;
}
</style>
  