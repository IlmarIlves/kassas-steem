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

        <div>
            <ul>
                <li v-for="item in bakingData" :key="item.id">
                    <span>Item: {{ item.name }}</span>
                    <ul>
                        <li v-for="ingredient in item.ingredients" :key="ingredient.id">
                            <div>
                                <p>Name: {{ ingredient.name }}</p>
                                <p> Quantity: {{ ingredient.quantity }}</p>
                            </div>
                        </li>
                    </ul>

                </li>
            </ul>
        </div>
    </div>
</template>
  
<script>
export default {
    name: 'Home',
};
</script>
  
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
  