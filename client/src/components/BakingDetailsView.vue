<script setup>
import { ref } from 'vue';
import axios from 'axios';

// Define a reactive variable to store the response data
const bakingData = ref();

const fetchData = async () => {
    try {
        const response = await axios.get('http://localhost:8080/api/baking-items/1');
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
        <h1 class="home-title">Welcome to the baking details</h1>
        <p class="home-content">This is the content of the baking details.</p>
    </div>

    <div>
        <ul>
            <li v-for="item in bakingData" :key="item.id">
                {{ item.name }}
                <ul>
                    <li v-for="ingredient in item.ingredients" :key="ingredient.id">
                        {{ ingredient }}
                    </li>
                </ul>
            </li>
        </ul>
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
  