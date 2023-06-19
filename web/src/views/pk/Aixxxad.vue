<template>
    <ContentField>
        <h2>404</h2>
        <div class="ac-game-chat-field-history">历史记录</div>
        <input type="text" class="ac-game-chat-field-input">
    </ContentField>
</template>


<script>
import ContentField from "@/components/ContentField.vue"

export default {
    components: {
        ContentField
    },
    // constructor(playground) {
    //     this.playground = playground;

    //     this.$history = $(`<div class="ac-game-chat-field-history">历史记录</div>`);
    //     this.$input = $(`<input type="text" class="ac-game-chat-field-input">`);

    //     this.$history.hide();
    //     this.$input.hide();

    //     this.func_id = null;

    //     this.playground.$playground.append(this.$history);
    //     this.playground.$playground.append(this.$input);

    //     this.start();
    // },

    // start() {
    //     this.add_listening_events();
    // },

    // add_listening_events() {
    //     let outer = this;

    //     this.$input.keydown(function(e) {
    //         if (e.which === 27) {  // ESC
    //             outer.hide_input();
    //             return false;
    //         } else if (e.which === 13) {  // ENTER
    //             let username = outer.playground.root.settings.username;
    //             let text = outer.$input.val();
    //             if (text) {
    //                 outer.$input.val("");
    //                 outer.add_message(username, text);
    //                 outer.playground.mps.send_message(username, text);
    //             }
    //             return false;
    //         }
    //     });
    // },

    // render_message(message) {
    //     return $(`<div>${message}</div>`);
    // },

    // add_message(username, text) {
    //     this.show_history();
    //     let message = `[${username}]${text}`;
    //     this.$history.append(this.render_message(message));
    //     this.$history.scrollTop(this.$history[0].scrollHeight);
    // },

    // show_history() {
    //     let outer = this;
    //     this.$history.fadeIn();

    //     if (this.func_id) clearTimeout(this.func_id);

    //     this.func_id = setTimeout(function() {
    //         outer.$history.fadeOut();
    //         outer.func_id = null;
    //     }, 3000);
    // },

    // show_input() {
    //     this.show_history();

    //     this.$input.show();
    //     this.$input.focus();
    // },

    // hide_input() {
    //     this.$input.hide();
    //     this.playground.game_map.$canvas.focus();
    // },
}
</script>

<style scoped>
.ac-game-chat-field-history {
    position: absolute;
    top: 66%;
    left: 20%;

    transform: translate(-50%, -50%);

    width: 20%;
    height: 32%;

    color: white;
    font-size: 2vh;

    padding: 5px;
    overflow: auto;
}

.ac-game-chat-field-history::-webkit-scrollbar {
    width: 0;
}

.ac-game-chat-field-input {
    position: absolute;
    top: 86%;
    left: 20%;
    transform: translate(-50%, -50%);

    width: 20%;
    height: 3vh;

    color: white;
    font-size: 2vh;

    background-color: rgba(222,225,230, 0.2);
}

</style>