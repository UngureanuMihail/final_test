Итоговая контрольная работа по блоку специализация

-Создание двух файлов Домашние животные и Вьючные животные в терминале операционной системы Linux, объединить их. Переименовать файл.

1.
cd ~/Michael 
cat > home_animals 
cat > pack_animals 
cat home_animals pack_animals > animals 
cat animals 
mv animals mans_friends 
ls -ali 


-Создание директории, перемещение файла.

2.
cd ..
mkdir Michael_base
cd ~/Michael
mv mans_friends ~/Michael_base
cd ~/Michael_base
ls -ali

-Подключение дополнительного репозитория MySQL. Установка пакета.

3.
sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.23-1_all.deb
sudo dpkg -i mysql-apt-config_0.8.23-1_all.deb
sudo apt-get update
sudo apt-get install mysql-server

-Установить и удалить deb-пакет с помощью dpkg.

4.
sudo wget https://download.docker.com/linux/ubuntu/dists/jammy/pool/stable/amd64/docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb
sudo dpkg -i docker-ce-cli_20.10.133-0ubuntu-jammy_amd64.deb
sudo dpkg -r docker-ce-cli
