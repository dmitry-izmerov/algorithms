package ru.demi.algorithms.leetcode.yandex.offerFor2DaysJanuary2024;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Музыкальный лейбл
 * Музыкальный лейбл аккумулировал вокруг себя тысячи артистов и собрал в своем архиве бессчетное количество треков,
 * музыкальных партий и битов. Накопленной музыкой лейбл активно делится со своими нынешними артистами.
 *
 * Архив с музыкой – это дерево ресурсов, в котором есть два типа узлов: директории и файлы. Файлы – это узлы у которых
 * нет “детей”. То есть листовые узлы, которые содержат конкретное музыкальное произведение. Директории – это узлы у
 * которых могут быть “дети”, по сути это папка с музыкальными произведениями.
 *
 * У каждого узла есть имя. У “детей” одной директории уникальные имена. Полный путь определяется названиями узлов
 * разделенные знаками /, например:
 * / – это корневая директория.
 * /Release – это директория с именем Release внутри корневой директории.
 * /Release/Echoes_of_Eternit – это директория Echoes_of_Eternit внутри директории Release.
 * /Release/Echoes_of_Eternit/Supernova.flac – это файл Supernova.flac внутри директории Echoes_of_Eternit.
 * Недавно лейбл столкнулся с проблемой: сломался сервис выдачи прав и работа многих артистов остановилась. Если артисты
 * не работают, лейбл теряет деньги, а слушатели не получают новые релизы. Вас позвали на помощь. Ваша задача: написать
 * сервис, который выдает пользователям (артистам и администраторам) права на узлы дерева и эти права проверяет.
 * По умолчанию, у пользователей отсутствуют какие-либо права. Есть два режима прав, read и write – права на чтение и на
 * запись файлов и директорий.
 * Чаще всего артисты получают права на чтение (они нужны, чтобы прослушивать и семпилировать музыкальные треки), а
 * администраторы лейбла права на запись (админы чаще просто добавляют новые релизы). Права на чтение и на запись
 * выдаются отдельно. У пользователя могут быть права как на чтение, так и на запись. При этом последняя операция
 * выдачи права является более приоритетной.
 *
 * Есть три операции:
 * grant user mode path – выдает доступ с режимом mode пользователю user на узел с путем равным path. Ответ – это строка
 * done
 * block user mode path – запрещает доступ с режимом mode пользователю user на узел c путем равным path. Ответ – это
 * строка done
 * check user mode path – проверяет, есть ли у пользователя user права с режимом mode до узла с путем равным path.
 * Ответ – это строка allowed или forbidden.
 * Все выданные права и запреты наследуются вниз по дереву. При этом, если возникает противоречие, правила, определенные
 * ниже по дереву, имеют более высокий приоритет.
 *
 * Формат ввода
 * В каждой строке входного файла записана одна из команд grant, block или check, с параметрами user, mode и path.
 * user - имя пользователя, непустая строка, длина не превышает 20
 * mode - режим доступа, строка со значением read или write.
 * path - путь до узла, непустая строка, всегда начинается с символа /, длина не превышает 50000.
 * Количество команд не превышает 50000.
 * Количество пользователей не превышает 50000.
 * Количество узлов в дереве ресурсов не превышает 100000.
 * Имя узла - непустая строка, длина не превышает 20.
 * Разрешенные символы в названиях узлов и именах пользователей: a-z, A-Z, 0-9, ., _.
 * Размер входного файла не превышает 1MiB.
 * Формат вывода
 * Для каждой команды выведите результат ее выполнения.
 * Для команд grant и block, это всегда строка со значением done.
 * Для команды check, это строка со значением allowed, если доступ разрешен, или forbidden, если в доступе отказано.
 *
 * Пример
 * Ввод:
 * grant bob read /home/bob
 * block bob read /
 * check bob read /home/bob/Pictures/gary.jpg
 * check bob read /etc/shadow
 * check bob write /home/bob/Pictures/gary.jpg
 * grant bob write /home/bob
 * check bob write /home/bob/Pictures/gary.jpg
 * block bob write /home/bob/Pictures
 * check bob write /home/bob/Pictures/gary.jpg
 * check bob read /home/bob/Pictures/gary.jpg
 * grant root read /
 * check root read /home/bob/Pictures/gary.jpg
 * check root read /etc/shadow
 *
 * Вывод:
 * done
 * done
 * allowed
 * forbidden
 * forbidden
 * done
 * allowed
 * done
 * forbidden
 * allowed
 * done
 * allowed
 * allowed
 */
public class Test3 {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = r.readLine()) != null) {
            String[] split = line.split(" ");
            var command = split[0];
            var user = split[1];
            var mode = split[2];
            var path = split[3];
            var file = File.of(path);
            file.run(command, user, mode);
        }
    }

    // TODO finish this
    static class File {
        Map<String, Map<String, Boolean>> permissions = new HashMap<>();
        List<File> files = new ArrayList<>();


        public static File of(String path) {
            return null;
        }

        public void run(String command, String user, String mode) {
            switch (command) {
                case "grant": {
                    grant(user, mode);
                    break;
                }
                case "block": {
                    block(user, mode);
                    break;
                }
                case "check": {
                    check(user, mode);
                    break;
                }
            }
        }

        private void grant(String user, String mode) {
        }

        private void block(String user, String mode) {
        }

        private void check(String user, String mode) {
        }
    }
}

