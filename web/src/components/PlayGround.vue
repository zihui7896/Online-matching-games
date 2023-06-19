<template>
    <div class="playground">
        <GameMap />
    </div>
    <!-- <div>
        <button @click="showChatBox = true">打开输入框</button>
        <div v-if="showChatBox" @keydown.enter="addMessage" @keydown.esc="showChatBox = false">
            <textarea v-model="message"></textarea>
            <div v-if="messages.length > 0">
                <h3>历史记录</h3>
                <ul>
                    <li v-for="(msg, index) in messages" :key="index">{{ msg }}</li>
                </ul>
            </div>
        </div>
    </div> -->
</template>

<script>
import GameMap from '@/components/GameMap.vue';
export default {
    components: {
        GameMap,
    },
    // data() {
    //     return {
    //         showChatBox: false,
    //         message: '',
    //         messages: []
    //     };
    // },
    // methods: {
    //     addMessage() {
    //         if (this.message.trim() !== '') {
    //             this.messages.unshift(this.message);
    //             this.message = '';
    //         }
    //     }
    // },
}
</script>

<style scoped>
div.playground {
    width: 60vw;
    height: 70vh;
    margin: 40px auto;
}
</style>