<template>
    <div class="home">
        <h1 class="home-title">Welcome to the baking list</h1>
        <p class="home-content">This is the content of the baking list.</p>
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
  