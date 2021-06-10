package com.botzhub;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotzHub extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        String cmd = update.getMessage().getText();
        if (cmd.equals("/start")) {
            if (update.getMessage().getChat().isUserChat() == true)
                sendmsg(update.getMessage().getChatId().toString(), "Hello.");
            else
                sendmsg(update.getMessage().getChatId().toString(), "Hello.");
        }
    }

    public void sendmsg(String chatid, String text) {
        SendMessage msg = new SendMessage(chatid, text);
        msg.enableHtml(true);
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "bot_username_here";
    }

    @Override
    public String getBotToken() {
        return "bot_token_here";
    }
}