import os
import pyperclip as pc
import gamma

os.chdir(os.path.dirname(__file__))

a = []
for root, dirs, files in os.walk('.'):
    # if not ('migrations' in root or '__pycache__' in root or 'instance' in root or '.git' in root or 'venv' in root or ('temp' in root and not 'templates' in root) or 'logs' in root):
    print(root)
    for file in files:
    # if file not in ['.gitignore', 'data_3.xlsx', 'copy_tree.py', '_utils.py', 'requirements.txt', 'run.sh'] and not 'import_' in file:
        a.append(os.path.join(root, file) + '\n' + gamma.read_file(os.path.join(root, file)))
                
pc.copy('\n'.join(a))