using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }
        public Revisor ObterPorId(int? id)
        {

            return contexto.Revisores.Where(a => a.Id == id).FirstOrDefault();

        }

        public Revisor Criar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();

            return revisor;
        }

        public Revisor Alterar(int id, Revisor revisor)
        {

            contexto.Entry(revisor).State = EntityState.Modified;
            contexto.SaveChanges();

            return ObterPorId(id);
        }

        public void Excluir(int id)
        {
            var revisorADeletar = contexto.Revisores.FirstOrDefault(x => x.Id == id);
            contexto.Revisores.Remove(revisorADeletar);
            contexto.SaveChanges();

        }
    }
}
