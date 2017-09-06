#！/bin/bash

chmod 777 ML.sh
chmod 777 scikit.sh
sudo apt-get -y install build-essential python-dev python-numpy python-setuptools python-scipy libatlas-dev libatlas3-base python-matplotlib  python-pip

sudo pip install -U scikit-learn seaborn
sudo pip install textblob
sudo pip install nltk
python -m textblob.download_corpora
