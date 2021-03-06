package myBot.telegram.commands.service;

import myBot.UtilsBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class StartCommand extends ServiceCommand {
    private final Logger logger = LoggerFactory.getLogger(StartCommand.class);
    public StartCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = UtilsBot.getUserName(user);

        logger.debug(String.format("Пользователь %s. Начато выполнение команды %s.", userName,
                this.getCommandIdentifier()));
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
                "Давайте начнём! Если Вам нужна помощь, нажмите /help");
        logger.debug(String.format("Пользователь %s. Завершено выполнение команды %s.", userName,
                this.getCommandIdentifier()));
    }
}
