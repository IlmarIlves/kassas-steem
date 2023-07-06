<script setup>
import BakingListView from './components/BakingListView.vue'
import BakingDetailsView from './components/BakingDetailsView.vue'
import BakingStatisticsView from './components/BakingStatisticsView.vue'
import NotFound from './components/NotFound.vue'
import { ref, computed } from 'vue'
import axios from 'axios';


const routes = {
  '/': BakingListView,
  '/details/:id': BakingDetailsView,
  '/statistics': BakingStatisticsView
}

const currentPath = ref(window.location.hash)

window.addEventListener('hashchange', () => {
  currentPath.value = window.location.hash
})

const currentView = computed(() => {
  return routes[currentPath.value.slice(1) || '/'] || NotFound
})

const fetchData = async () => {
  try {
    const response = await axios.get('http://localhost:8080/hello');
    const data = response.data;
    // Do something with the data
    console.log(data);
  } catch (error) {
    console.error(error);
  }
};

fetchData();

</script>

<template>
  <div>

    <router-link to="/">Home</router-link> |
    <router-link to="/details/:id">Details</router-link> |
    <router-link to="/statistics">Statistics</router-link> |
    <router-view></router-view>
  </div>
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
